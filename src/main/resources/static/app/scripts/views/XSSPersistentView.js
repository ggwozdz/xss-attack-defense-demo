/*global Static, Backbone, JST, Handlebars, CKEDITOR */

Static.Views = Static.Views || {};

(function () {
    'use strict';

    Static.Views.XSSPersistentView = Backbone.View.extend({
        el : '#xss-persistent-view',
        events: {
            "submit #xss-form" : "addComment",
        },

        initialize: function () {
            var templateContent = $('#xss-persistent-template').html();
            this.template = Handlebars.compile(templateContent)
            this.model    = new Static.Collections.Images();

            this.listenTo(this.model, 'all', this.render);
            this.model.fetch({async: false});

            console.log(this.model.toJSON());
        },

        render: function () {
            this.$el.html(this.template({images : this.model.toJSON()}));
            CKEDITOR.replace( 'editor1' );
            return this;
        },

        close: function(){
            this.$el.html('');
            this.stopListening();
            return this;
        },

        addComment : function(event){
            event.preventDefault();
            var imageUrl   = this.$("#image-url").val();
            var imageDescr = this.$("#image-descr").val();

            this.model.add({imageUrl: imageUrl, imageDescr: imageDescr});
        }
    });

})();
