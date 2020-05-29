<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div>
	<br>
	<br>
	<hr>
	<p>
		<a href="/"> Back </a>
	</p>


	<table class="table table-striped">
		<caption>Capability list of JDE Server running at
			"${serverConfig.defaultJasServer}"</caption>
		<thead>
			<tr>
				<th>Name</th>
				<th>Short Description</th>
				<th>Long Description</th>
				<th>asOfRelease</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${serverConfig.capabilityList}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.shortDescription}</td>
					<td>${item.longDescription}</td>
					<td>${item.asOfRelease}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="/"> Back </a>
	</p>


</div>
<%@ include file="common/footer.jspf"%>