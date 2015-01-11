<h3>Charts straight JS:</h3>
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<br />

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

<g:render template="chartsGoogleJSImage" />
