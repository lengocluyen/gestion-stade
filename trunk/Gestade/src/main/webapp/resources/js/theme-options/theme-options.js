$(document).ready(
		function($) {

			/* Selec your skin and layout Style */

			function interface() {

				// Skin value
				var skin = "orange"; // green (default), red
										// ,yellow,purple,blue, orange, purple,
										// pink, cocoa, custom

				// Boxed value
				var layout = "layout-semiboxed"; // layout-semiboxed(default),
													// layout-boxed,
													// layout-boxed-margin
													// ,layout-wide

				// Only in boxed version
				var bg = "none"; // none (default), bg1, bg2, bg3, bg4, bg5,
									// bg6, bg7, bg8, bg9, bg10, bg11

				// Theme Panel - disable panel options
				var themepanel = "1"; // 1 (default - enable), 0 ( disable)

				$(".skin").attr(
						"href",
						"http://localhost:8080/Gestade/resources/css/skins/"
								+ skin + "/" + skin + ".css");
				$("#layout").addClass(layout);
				$("body").addClass(bg);
				$("#theme-options").css('opacity', themepanel);
				return false;
			}

			interface();
		});
