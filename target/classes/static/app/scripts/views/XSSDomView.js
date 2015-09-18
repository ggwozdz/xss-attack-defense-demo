/*global Static, Backbone, JST*/

Static.Views = Static.Views || {};

(function () {
    'use strict';

    Static.Views.XSSDomView = Backbone.View.extend({

        el : '#xss-dom-view',
        events: {
            "submit #xss-form" : "addComment",
        },

        initialize: function () {
            var templateContent = $('#xss-dom-template').html();
            this.template = Handlebars.compile(templateContent)
            this.model    = new Backbone.Model({comments:[], evilStuff: '<button onclick="alert(\'waaaggh!\')">Button</button>'});

            this.listenTo(this.model, 'change', this.render);
        },

        render: function () {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },

        close: function(){
            this.$el.html('');
            this.stopListening();
            return this;
        },

        addComment : function(event){
            event.preventDefault();
            var comment  = this.$("#comment-input").val();
            var comments = _.clone(this.model.get("comments"));
            comments.push(comment);

            this.model.set({comments: comments});
        }

    });

})();
