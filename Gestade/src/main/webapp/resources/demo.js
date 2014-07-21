$(document)
		.ready(
				function() {

					var $calendar = $('#calendar');
					var id = 10;

					$calendar
							.weekCalendar({
								timeslotsPerHour : 4,
								allowCalEventOverlap : true,
								overlapEventsSeparate : true,
								firstDayOfWeek : 1,
								businessHours : {
									start : 3,
									end : 24,
									limitDisplay : true
								},
								daysToShow : 7,
								height : function($calendar) {
									return $(window).height()
											- $("h1").outerHeight() - 1;
								},
								eventRender : function(calEvent, $event) {
									if (getAccount() != null) {
										if (calEvent.end.getTime() < new Date()
												.getTime()) {
											$event.css("backgroundColor",
													"#aaa");
											$event.find(".wc-time").css({
												"backgroundColor" : "#999",
												"border" : "1px solid #888"
											});
										}
									}
								},
								draggable : function(calEvent, $event) {
									return calEvent.readOnly != true;
								},
								resizable : function(calEvent, $event) {
									return calEvent.readOnly != true;
								},
								eventNew : function(calEvent, $event) {
									if (getAccount() != null) {
										var $dialogContent = $("#event_edit_container");
										resetForm($dialogContent);
										var startField = $dialogContent.find(
												"select[name='start']").val(
												calEvent.start);
										var endField = $dialogContent.find(
												"select[name='end']").val(
												calEvent.end);
										var titleField = $dialogContent
												.find("input[name='title']");
										var bodyField = $dialogContent
												.find("textarea[name='body']");

										$dialogContent
												.dialog(
														{
															modal : true,
															title : "New Calendar Event",
															close : function() {
																$dialogContent
																		.dialog("destroy");
																$dialogContent
																		.hide();
																$('#calendar')
																		.weekCalendar(
																				"removeUnsavedEvents");
															},
															buttons : {
																save : function() {
																	calEvent.id = id;
																	id++;
																	calEvent.start = new Date(
																			startField
																					.val());
																	calEvent.end = new Date(
																			endField
																					.val());
																	calEvent.title = titleField
																			.val();
																	calEvent.body = bodyField
																			.val();
																	saveDataToServer(calEvent);

																	$calendar
																			.weekCalendar("removeUnsavedEvents");
																	$calendar
																			.weekCalendar(
																					"updateEvent",
																					calEvent);
																	$dialogContent
																			.dialog("close");
																},
																cancel : function() {
																	$dialogContent
																			.dialog("close");
																}
															}
														}).show();

										$dialogContent
												.find(".date_holder")
												.text(
														$calendar.weekCalendar(
																"formatDate",
																calEvent.start));
										setupStartAndEndTimeFields(startField,
												endField, calEvent,
												$calendar.weekCalendar(
														"getTimeslotTimes",
														calEvent.start));

									} else {
										alert("Vous n'avez pas connecte au system!");
									}
								},
								eventDrop : function(calEvent, $event) {

								},
								eventResize : function(calEvent, $event) {
								},
								eventClick : function(calEvent, $event) {

									if (calEvent.readOnly) {
										return;
									}
									if (getAccount() != null) {
										var $dialogContent = $("#event_edit_container");
										resetForm($dialogContent);
										var startField = $dialogContent.find(
												"select[name='start']").val(
												calEvent.start);
										var endField = $dialogContent.find(
												"select[name='end']").val(
												calEvent.end);
										var titleField = $dialogContent.find(
												"input[name='title']").val(
												calEvent.title);
										var bodyField = $dialogContent
												.find("textarea[name='body']");
										bodyField.val(calEvent.body);

										$dialogContent
												.dialog(
														{
															modal : true,
															title : "Edit - "
																	+ calEvent.title,
															close : function() {
																$dialogContent
																		.dialog("destroy");
																$dialogContent
																		.hide();
																$('#calendar')
																		.weekCalendar(
																				"removeUnsavedEvents");
															},
															buttons : {
																save : function() {

																	calEvent.start = new Date(
																			startField
																					.val());
																	calEvent.end = new Date(
																			endField
																					.val());
																	calEvent.title = titleField
																			.val();
																	calEvent.body = bodyField
																			.val();

																	saveDataToServer(calEvent);

																	$calendar
																			.weekCalendar(
																					"updateEvent",
																					calEvent);
																	$dialogContent
																			.dialog("close");
																},
																"delete" : function() {
																	$calendar
																			.weekCalendar(
																					"removeEvent",
																					calEvent.id);
																	$dialogContent
																			.dialog("close");
																},
																cancel : function() {
																	$dialogContent
																			.dialog("close");
																}
															}
														}).show();

										var startField = $dialogContent.find(
												"select[name='start']").val(
												calEvent.start);
										var endField = $dialogContent.find(
												"select[name='end']").val(
												calEvent.end);
										$dialogContent
												.find(".date_holder")
												.text(
														$calendar.weekCalendar(
																"formatDate",
																calEvent.start));
										setupStartAndEndTimeFields(startField,
												endField, calEvent,
												$calendar.weekCalendar(
														"getTimeslotTimes",
														calEvent.start));
										$(window).resize().resize(); // fixes
										// a
										// bug in
										// modal
										// overlay
										// size ??
									} else {
										alert("Vous n'avez pas connecte au system!");
									}

								},
								eventMouseover : function(calEvent, $event) {
								},
								eventMouseout : function(calEvent, $event) {
								},
								noEvents : function() {

								},
								data : function(start, end, callback) {
									callback(getEventData());
								}
							});

					function resetForm($dialogContent) {
						$dialogContent.find("input").val("");
						$dialogContent.find("textarea").val("");
					}
					function getAccount() {
						var result = "";
						$.ajax({
							url : "/Gestade/getaccount",
							dataType : 'json',
							async : false,
							success : function(json) {
								result = json;
							}
						});
						return result;
					}
					function saveDataToServer(data) {
						$.getJSON("/Gestade/createemploidutemps?start="
								+ data.start + "&end=" + data.end, function(
								response) {
							if (response == 'OK')
								alert('Ajout suces');
							else
								alert('Ajout fail');

						});
					}
					function getEventData() {
						var jsonArray=[];
						$
								.ajax({
									url : "/Gestade/getemploidutemps",
									dataType : 'json',
									async : false,
									success : function(data) {
										//temp = data;
										$.each(data.events, function(i, item) {
											jsonArray.push({
												id:item.id,
												start: new Date(item.year,item.month,item.day,item.startHour,item.startMinute,0),
												end:   new Date(item.year,item.month,item.day,item.endHour,item.endMinute,0),
												title:item.title
											});	

										});
									}
								});
						return {
							events : jsonArray
						};
					}

					/*
					 * Sets up the start and end time fields in the calendar
					 * event form for editing based on the calendar event being
					 * edited
					 */
					function setupStartAndEndTimeFields($startTimeField,
							$endTimeField, calEvent, timeslotTimes) {

						for (var i = 0; i < timeslotTimes.length; i++) {
							var startTime = timeslotTimes[i].start;
							var endTime = timeslotTimes[i].end;
							var startSelected = "";
							if (startTime.getTime() === calEvent.start
									.getTime()) {
								startSelected = "selected=\"selected\"";
							}
							var endSelected = "";
							if (endTime.getTime() === calEvent.end.getTime()) {
								endSelected = "selected=\"selected\"";
							}
							$startTimeField.append("<option value=\""
									+ startTime + "\" " + startSelected + ">"
									+ timeslotTimes[i].startFormatted
									+ "</option>");
							$endTimeField.append("<option value=\"" + endTime
									+ "\" " + endSelected + ">"
									+ timeslotTimes[i].endFormatted
									+ "</option>");

						}
						$endTimeOptions = $endTimeField.find("option");
						$startTimeField.trigger("change");
					}

					var $endTimeField = $("select[name='end']");
					var $endTimeOptions = $endTimeField.find("option");

					// reduces the end time options to be only after the start
					// time options.
					$("select[name='start']")
							.change(
									function() {
										var startTime = $(this).find(
												":selected").val();
										var currentEndTime = $endTimeField
												.find("option:selected").val();
										$endTimeField.html($endTimeOptions
												.filter(function() {
													return startTime < $(this)
															.val();
												}));

										var endTimeSelected = false;
										$endTimeField
												.find("option")
												.each(
														function() {
															if ($(this).val() === currentEndTime) {
																$(this)
																		.attr(
																				"selected",
																				"selected");
																endTimeSelected = true;
																return false;
															}
														});

										if (!endTimeSelected) {
											// automatically select an end date
											// 2 slots away.
											$endTimeField.find("option:eq(1)")
													.attr("selected",
															"selected");
										}

									});

					var $about = $("#about");

					$("#about_button").click(function() {
						$about.dialog({
							title : "About this calendar demo",
							width : 600,
							close : function() {
								$about.dialog("destroy");
								$about.hide();
							},
							buttons : {
								close : function() {
									$about.dialog("close");
								}
							}
						}).show();
					});

				});