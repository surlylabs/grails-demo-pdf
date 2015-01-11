var page = require('webpage').create(),
	system = require('system'),
	address, output, size;

if (system.args.length < 3 || system.args.length > 5) {
	console.log('Usage: rasterizestdout.js URL footerImageURL filename [paperwidth*paperheight|paperformat] [zoom]');
	console.log('  paper (pdf output) examples: "5in*7.5in", "10cm*20cm", "A4", "Letter"');
	phantom.exit(1);
} else {
	address = system.args[1];
	output = system.args[2];
	page.viewportSize = {width: 1400, height: 1024};
	if (system.args.length > 3) {
		footerImageUrl = system.args[3];
	}
	if (system.args.length > 4 && system.args[2].substr(-4) === ".pdf") {
		size = system.args[4].split('*');
		page.paperSize = size.length === 2 ? {width: size[0], height: size[1], margin: '0px'}
			: {format: system.args[3], orientation: 'landscape', margin: '1cm'};
	}
	if (system.args.length > 5) {
		page.zoomFactor = system.args[5];
	}

	page.paperSize = {
		format: "Letter",
		orientation: "portrait",
		footer: {
			height: "6.0cm",
			contents: phantom.callback(function(pageNum, numPages) {
				var footerHtml = "";
				if (footerImageUrl != null) {
					footerHtml = footerHtml + "<img src='" + footerImageUrl + "' alt='Surly Labs' />";
				}

				var tableFooter = "<table width='100%'><tr><td><small>Surly Labs LLC - 404 Post RD, Parts Unknown, MN 55101 USA</small></td>" +
					"<td>&nbsp;</td><td>&nbsp;</td>" +
					"<td colspan='2' style='text-align: right;'><small>" + pageNum + " / " + numPages + "</small></td></tr>" +
					" <tr><td><small>800-GO-SURLY | static@surlylabs.com</small></td></tr></table>";

				footerHtml = footerHtml + tableFooter;

				return footerHtml
			})
		}
	};

	page.onError = function(msg, trace) {
		console.log(msg);
		trace.forEach(function(item) {
			console.log('  ', item.file, ':', item.line);
		})
	};

	page.open(address, function(status) {
		if (status !== 'success') {
			console.log('Unable to load the address!');
			phantom.exit();
		} else {
			window.setTimeout(function() {
				page.render('/dev/stdout', {format: 'pdf'});
				phantom.exit();
			}, 200);
		}
	});
}
