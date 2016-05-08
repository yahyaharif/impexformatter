<%@taglib prefix="tag" uri="http://www.impexformatter.com/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<tag:master>
	<div class="panel panel-default" style="border-top: 1px solid #eee;">
		<div class="panel-body">
			<table id="result"
				class="table table-striped table-condensed table-responsive">
				<thead>
					<c:forEach var="column" items="${IHeaderColumns}">
						<th>${column}</th>
					</c:forEach>
				</thead>
			</table>
		</div>
	</div>
</tag:master>