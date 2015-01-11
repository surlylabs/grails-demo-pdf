<h3>Charts :google-visualization:0.7.2 plugin:</h3>
<gvisualization:apiImport />
<%
	def myDailyActivitiesColumns = [['string', 'Task'], ['number', 'Hours per Day']]
	def myDailyActivitiesData = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]
%>
View columns = ${myDailyActivitiesColumns}<br/>
View data = ${myDailyActivitiesData}<br/>
<gvisualization:pieCoreChart elementId="pluginPieChart" title="My Daily Activities Pie Plugin" width="${450}" height="${300}" columns="${myDailyActivitiesColumns}" data="${myDailyActivitiesData}" />
<div id="pluginPieChart"></div>

%{--Data passed in from controller--}%
Controller columns = ${columns}<br/>
Controller data = ${data}<br/>
<gvisualization:barCoreChart elementId="pluginBarChart" title="My Daily Activities Bar Plugin" width="${450}" height="${300}" columns="${columns}" data="${data}" />
<div id="pluginBarChart"></div>
