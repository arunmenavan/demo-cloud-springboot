<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div>
<form action="processJDEDataRequest" method="GET">
    <h1>Enter Resource Name</h1>
	<p><input type="text" name="resourceName" placeholder="What's the JDE resource name?"> </p>
	<input type="submit" />
</form>
</div>
<%@ include file="common/footer.jspf"%>