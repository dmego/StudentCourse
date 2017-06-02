function test(){
     var e = window.event;
     var iFrameElem = document.getElementById('iframe');
     var target = e.target||e.srcElement;
     if(target.getAttribute("id") == "stuadd"){
    	 iFrameElem.src="student/addStu.jsp";
     }else if(target.getAttribute("id") == "couradd"){
    	 iFrameElem.src="course/addCou.jsp";
     }else if(target.getAttribute("id") == "scadd"){
    	 iFrameElem.src="sc/addSC.jsp";
     }else if(target.getAttribute("id") == "scmanager"){
    	 iFrameElem.src="sc/scServlet?method=list";
     }else if(target.getAttribute("id") == "stumanager"){
    	 iFrameElem.src="student/stuServlet?method=list";
     }else if(target.getAttribute("id") == "coumanager"){
    	 iFrameElem.src="course/couServlet?method=list";
     }else if(target.getAttribute("id") == "infoSelect"){
    	 iFrameElem.src="info/infoSelect.jsp";
     }  
}

