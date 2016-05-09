<%@taglib prefix="tag" uri="http://www.impexformatter.com/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<tag:master>
	<div class="row">
		<div class="col-sm-4">
			<div class="panel panel-default" style="border-top: 1px solid #eee;">
				<div class="panel-body">
					<table class="table table-condensed">
						<tr>
							<td>Mode</td>
							<td><strong class="text-primary">${IHeaderInfo['mode']}</strong></td>
						</tr>
						<tr>
							<td>Type</td>
							<td><strong>${IHeaderInfo['type']}</strong></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="col-sm-8">
			<div class="panel panel-default" style="border-top: 1px solid #eee;">
				<div class="panel-body">
					<table class="table table-condensed">
						<c:forEach items="${IMacros}" var="macro">
							<tr>
								<td><strong class="text-danger">${macro.key}</strong></td>
								<td>${macro.value}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default" style="border-top: 1px solid #eee;">
				<div class="panel-body">
					<div class="table-responsive">
						<table id="result" class="table table-striped table-condensed">
							<thead>
								<c:forEach var="column" items="${IHeaderColumns}">
									<th>${column}</th>
								</c:forEach>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</tag:master>