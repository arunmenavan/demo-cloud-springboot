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
		<caption>Aggregation API Results:</caption>
		<thead>
			<tr>
				<th>Business Unit - Home</th>
				<th>Average Salary</th>
				<th>Employee Count</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${list.item}</td>
					<td>${list.item}</td>
					<td>${list.item}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<br> JSON response from the back end ${resBody}
	<p>
		<a href="/"> Back </a>
	</p>
	<br>
	<br> Response code from the back end for ${param.resourceName} :
	${resCode}



</div>
<%@ include file="common/footer.jspf"%>