<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<% 
response.setHeader("Pragma","No-cache");    
response.setHeader("Cache-Control","no-cache");    
response.setDateHeader("Expires", 0);   
%> 
<script type="text/javascript">
var v_pageSize = '${page.pageSize}';
var v_pageCount = '${page.pageCount}';
</script>
