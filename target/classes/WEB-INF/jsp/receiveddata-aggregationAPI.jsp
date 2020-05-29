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
		<caption>Aggregation of employees who's salary is greater than 50,000.00</caption>
		<thead>
			<tr>
				<th>Business Unit - Home</th>
				<th>Business Unit - #</th>
				<th>Average Salary</th>
				<th>Employee Count</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${apiResponse.output}" var="item">
				<tr>
				   <c:forEach items="${item.groupBy}" var="ent">
				        <c:set var="str1" value="${ent.key}" />
						<td>${fn:substring(str1, 8, 13)} </td>
						<td>${ent.value}</td>
					</c:forEach>
					<c:forEach items="${item.details}" var="entry">
						<td>${entry.value}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<p>
		<a href="/"> Back </a>
	</p>
	<br>



</div>
<%@ include file="common/footer.jspf"%>