jQuery.noConflict();
jQuery(document).ready(function($){
	$('#checkId').click(function(){
		var id = $('#TU_id').val();
		var err = 0;
		//alert(id);		
			if(id==""){
				//alert(id);
				$("#idResult").html("<font color='red'><b>아이디를 입력하세요</b></font>");
				//document.regForm.mem_id.focus();
				$("#TU_id").focus();
				return false;
			}else{				
				for(var i=0;i<id.length; i++){
					var chk = id.substring(i,i+1);
					if(!chk.match(/[0-9]|[a-z]|[A-Z]/)){
						err = err+1;
					}
				}
				if(err > 0){
					$('#idResult').html("<font color='red'>사용할수 없는 ID입니다.</font>");					
				}else{
					$.ajax({	
						async: true,
				        type : 'POST',
				        data : id,
				        url : "/TDLSpring/idcheck.do",
				        dataType:"json",
				        contentType: "application/json; charset=UTF-8",
				        success : function(data) {			        	 
				        	if(data.cnt==1){
				        		$('#idResult').html("<font color='red'>이미 존재하는 ID입니다.</font>");
				        	}else{
				        		$('#idResult').html("<font color='blue'>사용이 가능한 ID입니다.</font>");
				        	}
				        },error:function(request,status,error){
				            alert("통신실패");
				        }     
				     });
				}
			}
		});
	
});
