
function loadTarget(targetType){
	$('#duallist').empty();
	$('#duallist').bootstrapDualListbox('refresh');
	$.ajax({
		url : 'notice/target',
		dataType : 'json',
		data: {'targetType': targetType},
		async: false,
		success : function(response){
			if(response.result){
				$.each(response.result, function(i, n){
					var option = '<option value="'+n.id+'">';
					if(targetType == 1){
						option = option + n.alias;
					}else{
						option = option + n.phone;
					}
					option = option + '</option>';
					$('#duallist').append(option);
				});
				$('#duallist').bootstrapDualListbox('refresh');
			}
		}
	});
}

function initEditor(){
	$('#editor').ace_wysiwyg({
		toolbar:
		[
			'font',
			null,
//			'fontSize',
			{name: 'fontSize',values:{1 : '1' , 2 : '2' , 3 : '3' , 4 : '4' , 5 : '5', 6 : '6'}},
			null,
			{name:'bold', className:'btn-info'},
			{name:'italic', className:'btn-info'},
			{name:'strikethrough', className:'btn-info'},
			{name:'underline', className:'btn-info'},
			null,
			{name:'insertunorderedlist', className:'btn-success'},
			{name:'insertorderedlist', className:'btn-success'},
			{name:'outdent', className:'btn-purple'},
			{name:'indent', className:'btn-purple'},
			null,
			{name:'justifyleft', className:'btn-primary'},
			{name:'justifycenter', className:'btn-primary'},
			{name:'justifyright', className:'btn-primary'},
			{name:'justifyfull', className:'btn-inverse'},
			null,
//			{name:'createLink', className:'btn-pink'},
//			null,
//			{name:'unlink', className:'btn-pink'},
//			null,
			null,
//			{name:'insertImage', className:'btn-success'},
			null,
			null,
			'foreColor',
			null,
			{name:'undo', className:'btn-grey'},
			{name:'redo', className:'btn-grey'}
		],
//		'wysiwyg': {
//			fileUploadError: showErrorAlert
//		}
	}).prev().addClass('wysiwyg-style2');
}
//
//function showErrorAlert (reason, detail) {
//	var msg='';
//	if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
//	else {
//		//console.log("error uploading file", reason, detail);
//	}
//	$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
//	 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
//}

function initUploader(){
	var file_input = $("#multiple");
	var upload_in_progress = false;
	file_input.ace_file_input({
		style : 'well',
		btn_choose : 'Select or drop files here',
		btn_change: null,
		droppable: true,
		thumbnail: true ,
		
		maxSize: 110000,//bytes
		allowExt: ["jpeg", "jpg", "png", "gif"],
		allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif"],

		before_remove: function() {
			if(upload_in_progress)
				return false;//if we are in the middle of uploading a file, don't allow resetting file input
			return true;
		},

		preview_error: function(filename , code) {
			alert("code:"+code);
			//code = 1 means file load error
			//code = 2 image load error (possibly file is not an image)
			//code = 3 preview failed
		}
	})
	file_input.on('file.error.ace', function(ev, info) {
		if(info.error_count['ext'] || info.error_count['mime']) alert('Invalid file type! Please select an image!');
		if(info.error_count['size']) alert('Invalid file size! Maximum 100KB');
		
		//you can reset previous selection on error
		//ev.preventDefault();
		//file_input.ace_file_input('reset_input');
	});
}

// 上传控件重置
function resetUploader(){
	$("#multiple").ace_file_input('reset_input_ui');
}

// 序列化表单
function serializeForm(){
	var formData_object = new FormData($('#form')[0]);//create empty FormData object
	return formData_object;
}

var scripts = [null,
				"js/jquery.bootstrap-duallistbox.js",
				"js/jquery.raty.js",
				"js/bootstrap-multiselect.js",
				"js/select2.js",
				"js/bootstrap-wysiwyg.js",
				"js/typeahead.jquery.js", 
				"js/date-time/bootstrap-datepicker.js",
				null]
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
	  //inline scripts related to this page
		 jQuery(function($){
			initEditor();
			initUploader();
			// 初始化目标列表控件
		    var demo1 = $('select[name="target[]"]').bootstrapDualListbox({
		    	infoTextFiltered: '<span class="label label-purple label-lg">Filtered</span>',
//		    	nonSelectedListLabel: '目标列表',
		    	infoText: '共{0}个',
		    	moveAllLabel: '添加所有',
		    	removeAllLabel: '移除所有',
		    	infoTextEmpty: '共0个',
		    	bootstrap2Compatible: false,
		    	filterPlaceHolder: '过滤器',
		    	infoTextFiltered: '<span class="label label-warning">过滤:</span> {0} / {1}',
		    	filterTextClear: '所有'
		    });
			var container1 = demo1.bootstrapDualListbox('getContainer');
			container1.find('.btn').addClass('btn-white btn-info btn-bold');
		
			
			
			
			//////////////////
			//select2
			$('.select2').css('width','200px').select2({allowClear:true})
			$('#select2-multiple-style .btn').on('click', function(e){
				var target = $(this).find('input[type=radio]');
				var which = parseInt(target.val());
				if(which == 2){
					$('.select2').addClass('tag-input-style');
				}else {
					$('.select2').removeClass('tag-input-style');
				}
			});
			
			//////////////////
			$('.multiselect').multiselect({
				 enableFiltering: true,
				 buttonClass: 'btn btn-white btn-primary',
				 templates: {
					button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"></button>',
					ul: '<ul class="multiselect-container dropdown-menu"></ul>',
					filter: '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
					filterClearBtn: '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
					li: '<li><a href="javascript:void(0);"><label></label></a></li>',
					divider: '<li class="multiselect-item divider"></li>',
					liGroup: '<li class="multiselect-item group"><label class="multiselect-group"></label></li>'
				 }
			});
			
			
			///////////////////
				
			//typeahead.js
			//example taken from plugin's page at: https://twitter.github.io/typeahead.js/examples/
			var substringMatcher = function(strs) {
				return function findMatches(q, cb) {
					var matches, substringRegex;
					// an array that will be populated with substring matches
					matches = [];
					// regex used to determine if a string contains the substring `q`
					substrRegex = new RegExp(q, 'i');
				 
					// iterate through the pool of strings and for any string that
					// contains the substring `q`, add it to the `matches` array
					$.each(strs, function(i, str) {
						if (substrRegex.test(str)) {
							// the typeahead jQuery plugin expects suggestions to a
							// JavaScript object, refer to typeahead docs for more info
							matches.push({ value: str });
						}
					});
					cb(matches);
				}
			 }
			// 初始化日期控件
			$('.input-daterange').datepicker({
									autoclose:true,
									language:'zh-CN',
									format: 'yyyy-mm-dd',
								});
		
			
			//in ajax mode, remove remaining elements before leaving page
//			$(document).one('ajaxloadstart.page', function(e) {
//				$('[class*=select2]').remove();
//				$('select[name="target[]"]').bootstrapDualListbox('destroy');
//				$('.rating').raty('destroy');
//				$('.multiselect').multiselect('destroy');
//			});
//			
			// 公告内容控件切换
			$(":radio[name=type]").click(function(){
				var radioV = $(this).val();
				if(radioV == 1){
					$('#editor').empty();
					$("#picBox").show()
					$("#contentBox").hide()
				}else{
					resetUploader();
					$("#contentBox").show()
					$("#picBox").hide()
				}
		    });
			
			// 目标类型切换		0：园区  1:楼栋   2：手机
			$(":radio[name=targetType]").click(function(){
				var radioV = $(this).val();
				if(radioV == 1){
					$("#targetBox").show()
					loadTarget(1)
				}else if(radioV == 2){
					$("#targetBox").show()
					loadTarget(2)
				}else{
					$('#duallist').empty();
					$("#targetBox").hide()
				}
			});
			
			//表单重置
			$("#reset").on("click", function(){
				window.location.reload();
			})
			
			// 表单提交
			$("#submit").on("click", function(){
				var title = $('input[name="title"]').val();
				var type = $('input[name="type"]:checked').val();
//				var content = $('textarea[name="content"]').val();
				var content = $('#editor').html();
				var devices = $('select[name="target[]"]').val();
				
				if(title == null || $.trim(title)==''){
					alert('标题不能为空');
					return;
				}
				
				// 序列化普通表单
				var formData = serializeForm();
//				formData.append("devices",JSON.stringify(devices));
				
				if(type == 2){
					formData.append("content",content);
					formData.delete("files");
				}else{
					formData.delete("content");
				}
				
				$.ajax({
					url : 'notice/save',
					type: 'post',
					processData: false,//important
					contentType: false,//important
					dataType : 'json',
//					data: {'title':title,'type':type,'content':content,'devices':JSON.stringify(devices)},
					data: formData,
					success : function(data){
						if(data.code == 1){
							alert('发布成功！');
							window.location.reload();
						}else{
							alert("发布失败！");
						}
					}
				});
			});
		});
	});

