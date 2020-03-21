var dialog = dialog || {};
dialog = {
	normal: function(options) {
		var langPack = {
			cn: {
				ok: "确定",
				cancel: "取消",
				title: "信息提示"
			},
			en: {
				ok: "Confirm",
				cancel: "Cancel",
				title: "Tips"
			}
		};
		options.lang = options.lang || "cn";
		var lp = langPack[options.lang];
		options.id = options.id || "";
		options.hastitle = options.hastitle == undefined ? true : options.hastitle;
		options.title = options.title || "";
		options.html = options.html || lp.title + ": " + options.id;
		options.button = options.button || 0;
		options.size = options.size || "";
		options.btnText1 = options.btnText1 || lp.ok;
		options.btnText2 = options.btnText2 || lp.cancel;
		options.callback = options.callback || function() {};
		if(!window["mymodal" + options.id]) {
			function _modal() {
				var _html = '<div class="modal" data-keyboard="false" data-backdrop="static" id="modal' + options.id + '" tabindex="-1" role="dialog" aria-describedby="modal-body' + options.id + '" aria-labelledby="myModalLabel' + options.id + '" aria-hidden="true">';
				_html += '<div class="modal-dialog modal-' + options.size + '">';
				_html += '<div class="modal-content">';
				if(options.hastitle) {
					_html += '<div class="modal-header clearfix">';
					_html += '<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="icon-cancel"></i></button>';
					_html += '<h4 class="modal-title" id="myModalLabel' + options.id + '">' + options.title + '</h4>';
					_html += '</div>';
				}
				_html += '<div class="modal-body" id="modal-body' + options.id + '">';
				_html += options.html
				_html += '</div>';
				if(options.button != 0) {
					_html += '<div class="modal-footer">';
					if(options.button == 1) {
						_html += '<button type="button" class="btn btn-default" id="modal' + options.id + '-btn1">' + options.btnText1 + '</button>';
					} else if(options.button == 2) {
						_html += '<button type="button" class="btn btn-primary" id="modal' + options.id + '-btn1">' + options.btnText1 + '</button>';
						_html += '<button type="button" class="btn btn-default" data-dismiss="modal">' + options.btnText2 + '</button>';
					}
					_html += '</div>';
				}
				_html += '</div></div></div>';
				$("body").append(_html);
			}

			function bindCallback(callback) {
				if(options.button >= 1) {
					$("#modal" + options.id + "-btn1").off("click").on("click", function() {
						if(callback && typeof(callback) == "function") {
							callback();
						}
						window["mymodal" + options.id].hide();
					});
				}
			}
			_modal.prototype.show = function(content, title, callback) {
				$("#myModalLabel" + options.id).html(title || options.title);
				$("#modal-body" + options.id).html(content || options.html);
				$("#modal" + options.id).modal("show");
				_modal.prototype.self = $("#modal" + options.id);
				bindCallback(callback || options.callback);
				if(options.onshow) {
					options.onshow();
				}
			}
			_modal.prototype.hide = function() {
				$("#modal-body" + options.id).html("");
				$("#modal" + options.id).modal("hide");
				if(options.onhide) {
					options.onhide();
				}
			}
			_modal.prototype.self = $("#modal" + options.id);
			window["mymodal" + options.id] = new _modal();
		}
		return window["mymodal" + options.id]
	},
	alert: function(msg, type, callback, lang) {
		var langPack = {
			cn: {
				title: "信息提示",
				title_error: "错误提示",
				title_success: "成功提示",
				title_warning: "警告提示"
			},
			en: {
				title: "Information",
				title_error: "Error",
				title_success: "Success",
				title_warning: "Warning"
			}
		};
		lang = lang || "cn";
		var lp = langPack[lang];
		var title = lp.title;
		var tipIco = " <i class='fa fa-info-circle fa-fw fsize-16 text-primary'></i> ";
		if(type) {
			switch(type) {
				case "e":
					title = lp.title_error;
					tipIco = " <i class='fa fa-close fa-fw text-danger'></i> ";
					break;
				case "s":
					title = lp.title_success;
					tipIco = " <i class='fa fa-check-circle fa-fw text-success'></i> ";
					break;
				case "w":
					title = lp.title_warning;
					tipIco = " <i class='fa fa-exclamation-triangle fa-fw text-warning'></i> ";
					break;
				default:
					tipIco = " <i class='fa fa-info fa-fw text-primary'></i> ";
					break;
			}
		}
		var alertbox = this.normal({
			id: "-dialog-alert",
			button: 1,
			lang: lang
		});
		alertbox.show(msg, tipIco + title, callback);
		return alertbox;
	},
	loading: function(msg) {
		var _msg = "<div class='center-block text-center fs24'><i class='icon-spin4 animate-spin fs24'></i> " + (msg || "loading···") + "</div>";
		var loadingBox = this.normal({
			id: "-dialog-loading",
			button: 0,
			size: "sm",
			hastitle: false
		});
		loadingBox.show(_msg);
		return loadingBox;
	}
};