<div style="padding-bottom: 20px">
	<h3>Charts smoke-test js only:</h3>
	<script type="text/javascript" src="http://www.google.com/jsapi"></script>

	<h3>Pie Chart JS:</h3>
	<script>
		google.load('visualization', '1', {'packages': ['corechart']});
		google.setOnLoadCallback(drawVisualization);

		function drawVisualization() {
			visualization_data = new google.visualization.DataTable();
			visualization_data.addColumn('string', 'Task');
			visualization_data.addColumn('number', 'Hours per Day');
			visualization_data.addRow(['Work', 11]);
			visualization_data.addRow(['Eat', 2]);
			visualization_data.addRow(['Commute', 2]);
			visualization_data.addRow(['Watch TV', 2]);
			visualization_data.addRow(['Sleep', 7]);
			visualization = new google.visualization.PieChart(document.getElementById('piechart'));
			visualization.draw(visualization_data, {title: 'My Daily Activities Pie', width: 450, height: 300});
		}
	</script>
	<div id="piechart"></div>

	<h3>Bar Chart JS:</h3>
	<script type="text/javascript">
		google.load('visualization', '1', {'packages': ['corechart']});
		google.setOnLoadCallback(drawVisualization);

		function drawVisualization() {
			visualization_data = new google.visualization.DataTable();
			visualization_data.addColumn('string', 'Task');
			visualization_data.addColumn('number', 'Hours per Day');
			visualization_data.addRow(['Work', 11]);
			visualization_data.addRow(['Eat', 2]);
			visualization_data.addRow(['Commute', 2]);
			visualization_data.addRow(['Watch TV', 2]);
			visualization_data.addRow(['Sleep', 7]);

			visualization = new google.visualization.BarChart(document.getElementById('barCoreChart'));
			visualization.draw(visualization_data, {title: 'My Daily Activities Bar', width: 450, height: 300});
		}
	</script>
	<div id="barCoreChart"></div>

	%{--TODO--}%
	<br />
	<br />
	<br />
	<br />
	<h3>Image Bar Chart JS:</h3>
	%{--Printing--}%
	%{--https://developers.google.com/chart/interactive/docs/printing--}%
	<script type="text/javascript">
		google.load("visualization", '1', {packages: ['corechart']});
		google.setOnLoadCallback(drawChart);
		function drawChart() {
			var data = google.visualization.arrayToDataTable([
				['Element', 'Density', {role: 'style'}],
				['Copper', 8.94, '#b87333',],
				['Silver', 10.49, 'silver'],
				['Gold', 19.30, 'gold'],
				['Platinum', 21.45, 'color: #e5e4e2']
			]);

			var options = {
				title: "Density of Precious Metals, in g/cm^3",
				bar: {groupWidth: '95%'},
				legend: 'none'
			};
			var chart_div = document.getElementById('imageBarChart');
			var chart = new google.visualization.ColumnChart(chart_div);
			// Wait for the chart to finish drawing before calling the getImageURI() method.
			google.visualization.events.addListener(chart, 'ready', function() {
				chart_div.innerHTML = '<img src="' + chart.getImageURI() + '" />';
				console.log(chart_div.innerHTML);
			});

			chart.draw(data, options);
		}
	</script>
	<div id='imageBarChart'></div>

	%{--TODO--}%
	%{--<h3>Charts smoke-test :google-visualization:0.7.2 plugin:</h3>--}%
	%{--<gvisualization:apiImport />--}%
	%{--<%--}%
		%{--def myDailyActivitiesColumns = [['string', 'Task'], ['number', 'Hours per Day']]--}%
		%{--def myDailyActivitiesData = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]--}%
	%{--%>--}%
	%{--<gvisualization:pieCoreChart elementId="pluginPieChart" title="My Daily Activities Pie Plugin" width="${450}" height="${300}" columns="${myDailyActivitiesColumns}" data="${myDailyActivitiesData}" />--}%
	%{--<div id="pluginPieChart"></div>--}%

	%{--<gvisualization:barCoreChart elementId="pluginBarChart" title="My Daily Activities Bar Plugin" width="${450}" height="${300}" columns="${myDailyActivitiesColumns}" data="${myDailyActivitiesData}" />--}%
	%{--<div id="pluginBarChart"></div>--}%
</div>
