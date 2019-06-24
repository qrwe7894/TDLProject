<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
 <%
	String TU_id="테스트";
	String TN_id="";
%>
<jsp:include page="../main/head.jsp"/>

<!-- 자유게시판 list header -->
<section id="content" class="board-list-header-wrap">
	<div class="container">
		<h3 class="board-list-header"><i class="icon-clipboard-list" style="margin-right: 10px;"></i>자유게시판</h3>
	</div>
</section>


<section id="content">
	<div class="container board-view-con">
		<div class="board-view-tit">
			${articleN.TN_title }
		</div>
	</div>
</section>	

<section id="content">
	<div class="container board-view-con board-view-con1">
		<div class="board-view-info">
			<span><i class="icon-user-edit"></i>${articleN.TN_id }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span><i class="icon-clock"></i> ${articleN.TN_date }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span><i class="icon-line-eye"></i> 8</span>
		</div>
	</div>
</section>
	
<section id="content">
	<div class="container board-view-con">
		<div class="board-view-sub">
			<pre>${articleN.TN_content }</pre>
		</div>
	</div>
</section>	
	
		
<section id="content">
	<div class="container board-view-con board-view-con1">
		<div class="board-view-sub board-view-utilbtn">
<%-- 			<c:if test="${TN_id || articleN.TN_id==TU_id}"> --%>
				<a href="/TDLSpring/TDL_NOTICE/TDLNoticeUpdate.do?TN_num=${articleN.TN_num}"><button class="button">글수정</button></a>
				<a href="/TDLSpring/TDL_NOTICE/TDLNoticeDelete.do?TN_num=${articleN.TN_num}"><button class="button">글삭제</button></a>
		<%-- 	</c:if> --%>
				<a href="/TDLSpring/TDL_NOTICE/TDLNoticeList.do"><button class="button">글목록</button></a>
		</div>
	</div>
</section>				
	
	



<script src="../js/jquery.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/functions.js"></script>

<!-- SLIDER REVOLUTION 5.x SCRIPTS  -->
	<script src="../include/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
	<script src="../include/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	
	<script src="../include/rs-plugin/js/extensions/revolution.extension.video.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.actions.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.kenburn.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.navigation.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.migration.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.parallax.min.js"></script>
</body>
</html>