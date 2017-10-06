var Inbox = function () {

    var content = $('.inbox-content');
    var loading = $('.inbox-loading');
    var topurl="";
    var topname="";
    var pagecount=0;
    var loadInbox = function (name,url,searchname) {
        //var url = 'inbox_inbox.html';
        var title = $('.inbox-nav > li.' + name + ' a').attr('data-title');

        loading.show();
        content.html('');
        var data={searchname:searchname};
        $.getJSON(url,data, function (res) {
        	var pi=res.pi;
        	pagecount=pi.pageCount;
        	var chtml='';
        	chtml+='<table class="table table-striped table-advance table-hover"><thead>';
        	chtml+='<tr>';
        	chtml+='<th colspan="3"><input type="checkbox" class="mail-checkbox mail-group-checkbox" />';
        	chtml+='<div class="btn-group">';
        	chtml+='<a class="btn mini blue" href="#" data-toggle="dropdown"> 更多 <i class="icon-angle-down "></i> </a>'; 
        	chtml+='<ul class="dropdown-menu">'; 
        	chtml+='<li><a href="#"><i class="icon-pencil"></i> Mark as Read</a></li>'; 
        	chtml+='<li class="divider"></li>'; 
        	chtml+='<li><a href="#"><i class="icon-trash"></i>删除</a></li>'; 
        	chtml+='</ul>'; 
        	chtml+='</div> </th>'; 
        	chtml+='<th class="text-right" colspan="3">'; 
        	chtml+='<ul class="unstyled inline inbox-nav">'; 
        	chtml+='<li><span>从('+pi.startRow+')条到('+(pi.startRow*1+pi.pageSize*1)+')条 共 ('+pi.recordCount+')条</span></li>'; 
        	chtml+='<li><i class="icon-angle-left  pagination-left"></i></li>'; 
        	chtml+='<li><i class="icon-angle-right pagination-right"></i></li>'; 
        	chtml+='</ul> </th>'; 
        	chtml+='</tr>'; 
        	chtml+='</thead>'; 
        	chtml+='<tbody><tr><td></td><td></td><td>发件人</td><td>主题</td><td></td><td style="text-align:right;">发件时间</td></tr>';
        	for ( var int = 0; int < res.fs.length; int++) {
        		var row=res.fs[int];
        		var time=row.senderTime.split("T");
        		var de=time[0]+" "+time[1];
        		chtml+='<tr class="unread">'+
        	     '<td class="inbox-small-cells"> <input type="checkbox" class="mail-checkbox" /> </td>';
        		if (row.paramSysparamByImportant != null) {
					chtml+='<td class="inbox-small-cells"><i class="icon-star inbox-started" flowid="'+row.id+'"></i> </td>';
				}else{
					chtml+='<td class="inbox-small-cells"><i class="icon-star" flowid="'+row.id+'"></i> </td>';
				}
        	     chtml+='<td class="hidden-phone">'+row.hrEmployeeBySenderId.name+'</td>'+
        	     '<td class="view-message"><a href="#" url="mail_flow!ajaxLoadOneById?id='+row.id+'">'+row.mailTitle.substring(0,30)+'</a></td>';
        	    if (row.mailAttachments.length>0) {
            	     chtml+='<td class="inbox-small-cells"><i class="icon-paper-clip"></i></td>';
				}else{
					chtml+='<td class="inbox-small-cells"></td>';
				}
        	     chtml+='<td style="text-align:right;">'+de+'</td></tr>';
			}
    		chtml+='</tbody></table>';
            $('.inbox-nav > li.active').removeClass('active');
            $('.inbox-nav > li.' + name).addClass('active');
            $('.inbox-header > h1').text(title);
            loading.hide();
            content.html(chtml);
            App.fixContentHeight();
            App.initUniform();
        });
    };

    var loadMessage = function (url) {
        loading.show();
        content.html('');
        
        $.getJSON(url,function (res) {
        	var time=res.senderTime.split("T");
    		var de=time[0]+" "+time[1];
        	var chtml='\
        	<div class="portlet">\
            <div class="portlet-title"><div class="caption">\
              <i class="icon-reorder"></i>标题：'+res.mailTitle+'\
             </div>\
             <div class="actions">';
        	if (res.hrEmployeeBySenderId.id!=res.paramSysparamByReciveTypeId.id) {
        		chtml+='<a href="mail_flow!del?id='+res.id+'" class="btn blue mini"><i class="icon-trash"></i>删除</a> \
                    <a href="mail_flow!delete?id='+res.id+'" class="btn mini purple"><i class="icon-trash"></i>彻底删除</a>';
			}
             chtml+='</div></div>\
           <div class="portlet-title"><div class="caption">\
            <i class="icon-time"></i>发送时间： '+de+'&nbsp;&nbsp;&nbsp;\
                        发件人：'+res.hrEmployeeBySenderId.name+'&nbsp;&nbsp;&nbsp;收件人：'+res.hrEmployeeByReceiveId.name+'</div>\
          </div> \
            <div class="portlet-body">\
              <font style="font-weight: bolder; font-size:15px; color:#4D82A3;">文本内容：</font>'+res.mailContent+'\
              <hr/>\
              <div class="alert alert-info"><button class="close" data-dismiss="alert"></button>\
              <strong>提醒！</strong> 如下附件单击可以下载！ \
             </div> \
              <font style="font-weight: bolder; font-size:15px; color:#4D82A3;">附件内容('+res.mailAttachments.length+')：</font><br>';
        	var attac=res.mailAttachments;
        	for ( var int = 0; int < attac.length; int++) {
				chtml+='<a class="btn mini green" href="'+attac[int].fileUrl+'" ><i class="icon-file"></i>'+attac[int].fileName+'</a>&nbsp;&nbsp;';
			}
        	chtml+='</div></div>';
        		
            $('.inbox-header > h1').text('查看邮件');
            loading.hide();
            content.html(chtml);
            App.fixContentHeight();
            App.initUniform();
        });
    };

    var initTags = function (input) {
        input.tag({
            autosizedInput: true,
            containerClasses: 'span12',
            inputClasses: 'm-wrap',
            source: function (query, process) {
                return [
                    'Bob Nilson <bob.nilson@metronic.com>',
                    'Lisa Miller <lisa.miller@metronic.com>',
                    'Test <test@domain.com>',
                    'Dino <dino@demo.com>',
                    'Support <support@demo.com>'];
            }
        });
    };

    var initWysihtml5 = function () {
        $('.inbox-wysihtml5').wysihtml5({
            "stylesheets": ["assets/plugins/bootstrap-wysihtml5/wysiwyg-color.css"]
        });
    };

    var initFileupload = function () {

        $('#fileupload').fileupload({
            // Uncomment the following to send cross-domain cookies:
            //xhrFields: {withCredentials: true},
            url: 'assets/plugins/jquery-file-upload/server/php/',
            autoUpload: true
        });

        // Upload server status check for browsers with CORS support:
        if ($.support.cors) {
            $.ajax({
                url: 'assets/plugins/jquery-file-upload/server/php/',
                type: 'HEAD'
            }).fail(function () {
                $('<span class="alert alert-error"/>')
                    .text('Upload server currently unavailable - ' +
                    new Date())
                    .appendTo('#fileupload');
            });
        }
    };

    var loadCompose = function () {
        var url = 'mail_add.jsp';
        
        loading.show();
        content.html('');

        // load the form via ajax
        $.post(url, {}, function (res) {
            $('.inbox-nav > li.active').removeClass('active');
            $('.inbox-header > h1').text('写邮件');
            $('.inbox-nav > li').eq(0).nextAll().hide();
            $('.inbox-nav').append('<li class="compose-btn"><a class="btn" href="mail_flow.jsp" ><i class="icon-arrow-left"></i>返回</a><b></b></li> ');
            loading.hide();
            content.html(res);

            initTags($('[name="to"]'));
            initFileupload();
            initWysihtml5();

            $('.inbox-wysihtml5').focus();
            App.fixContentHeight();
            App.initUniform();
        });
    };

    var loadReply = function () {
        var url = 'inbox_reply.html';

        loading.show();
        content.html('');

        // load the form via ajax
        $.post(url, {}, function (res) {
            $('.inbox-nav > li.active').removeClass('active');
            $('.inbox-header > h1').text('Reply');

            loading.hide();
            content.html(res);
            $('[name="message"]').val($('#reply_email_content_body').html());

            initTags($('[name="to"]')); // init "TO" input field
            handleCCInput(); // init "CC" input field

            initFileupload();
            initWysihtml5();
            App.fixContentHeight();
            App.initUniform();
        });
    };

    /*var loadSearchResults = function () {
        var url = 'inbox_search_result.html';

        loading.show();
        content.html('');

        $.post(url, {}, function (res) {
            $('.inbox-nav > li.active').removeClass('active');
            $('.inbox-header > h1').text('Search');

            loading.hide();
            content.html(res);
            App.fixContentHeight();
            App.initUniform();
        });
    };*/

    var handleCCInput = function () {
        var the = $('.inbox-compose .mail-to .inbox-cc');
        var input = $('.inbox-compose .input-cc');
        the.hide();
        input.show();
        initTags($('[name="cc"]'), -10);
        $('.close', input).click(function () {
            input.hide();
            the.show();
        });
    };

    var handleBCCInput = function () {

        var the = $('.inbox-compose .mail-to .inbox-bcc');
        var input = $('.inbox-compose .input-bcc');
        the.hide();
        input.show();
        initTags($('[name="bcc"]'), -10);
        $('.close', input).click(function () {
            input.hide();
            the.show();
        });
    };

    return {
        //main function to initiate the module
        init: function () {
        	//user star
        	$('.inbox-small-cells >.icon-star').live('click',function(){
        		var $cur=$(this);
    			var url="mail_flow!setStar?id="+$cur.attr('flowid')+"&v="+new Date().valueOf();
        		if($cur.hasClass('inbox-started')){
        			$.get(url,function(d){
        				if (d=="success") {
        					$cur.removeClass('inbox-started');
						}
        			});
        		}else{
        			$.get(url,function(d){
        				if (d=="success") {
        					$cur.addClass('inbox-started');
						}
        			});
        		}
        	});
        	var pageIndex=1;//页码
        	//上页
        	$('.inbox-nav .pagination-left').live('click',function(){
        		if ((pageIndex*1-1)==0) {
        			alert('已经是第一页');
					return;
				}
        		var i=topurl.indexOf('=', 0)
        		var url=topurl.substring(0, i+1)+new Date().valueOf()+"&index="+(pageIndex-1);
        		loadInbox(topname,url);
        		pageIndex--;
        	})
        	//下页
        	$('.inbox-nav .pagination-right').live('click',function(){
        		if (pageIndex>=pagecount) {
					alert('已经最后一页了');
					return;
				}
        		var i=topurl.indexOf('=', 0)
        		var url=topurl.substring(0, i+1)+new Date().valueOf()+"&index="+(pageIndex+1);
        		loadInbox(topname,url);
        		pageIndex++;
        	})
            // handle compose btn click
            $('.inbox .compose-btn a').live('click', function () {
                loadCompose();
            });

            // handle reply and forward button click
            $('.inbox .reply-btn').live('click', function () {
                loadReply();
            });

            // handle view message
            $('.inbox-content .view-message').live('click', function () {
            	var url=$(this).find('a').attr('url');
                loadMessage(url+'&v='+new Date().valueOf());
            });

            // handle inbox listing新邮件
            $('.inbox-nav > li.inbox > a').click(function () {
            	var url="../pages_mail/mail_flow!ajaxLoadNewMail?v="+new Date().valueOf();
            	topurl=url;topname='inbox';pageIndex=1;
                loadInbox('inbox',url);
            });

            // handle sent listing已发送
            $('.inbox-nav > li.sent > a').click(function () {
            	var url="../pages_mail/mail_flow!ajaxLoadSendMail?v="+new Date().valueOf();
            	topurl=url;topname='send';pageIndex=1;
                loadInbox('sent',url);
            });

            // handle draft listing收件箱
            $('.inbox-nav > li.draft > a').click(function () {
            	var url="../pages_mail/mail_flow!ajaxLoadAllMail?v="+new Date().valueOf();
            	topurl=url;topname='draft';pageIndex=1;
                loadInbox('draft',url);
            });
            // handle star listing星标邮件
            $('.inbox-nav > li.star > a').click(function () {
            	var url="../pages_mail/mail_flow!ajaxLoadStarMail?v="+new Date().valueOf();
            	topurl=url;topname='star';pageIndex=1;
                loadInbox('star',url);
            });
            
            // handle trash listing已删除
            $('.inbox-nav > li.trash > a').click(function () {
            	var url="../pages_mail/mail_flow!ajaxLoadTrashMail?v="+new Date().valueOf();
            	topurl=url;topname='trash';pageIndex=1;
                loadInbox('trash',url);
            });
            //search mail
            $('#btn-searchmail').click(function(){
            	var txt = $('#searchmail').val();
        		url="mail_flow!ajaxSearchMailByName?v="+new Date().valueOf(),
        		loadInbox('search',url,txt);
            });
            
            //handle compose/reply cc input toggle
            $('.inbox-compose .mail-to .inbox-cc').live('click', function () {
                handleCCInput();
            });

            //handle compose/reply bcc input toggle
            $('.inbox-compose .mail-to .inbox-bcc').live('click', function () {
                handleBCCInput();
            });

            //handle loading content based on URL parameter
            if (App.getURLParameter("a") === "view") {
                loadMessage();
            } else if (App.getURLParameter("a") === "compose") {
                loadCompose();
            } else {
            	$.ajax({
    				async:false,
    				cache:false,
    				type:"get",
    				url:"../pages_mail/mail_flow!ajaxLoadNewCount?v="+new Date().valueOf(),
    				dataType:"text",
    				success:function(d){
    					if(d.trim()!=""){
    		            	$('.inbox-nav > li.inbox > a').text('新邮件('+d+')');
    					}
    				},
    				error:function(){
    					alert("网络异常!");
    				}
    			});
            	var url="../pages_mail/mail_flow!ajaxLoadNewMail?v="+new Date().valueOf();
            	topurl=url;
            	topname='inbox';
                loadInbox('inbox',url);
            }

        }

    };

}();