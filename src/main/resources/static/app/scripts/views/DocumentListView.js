/*global Static, Backbone, JST*/

Static.Views = Static.Views || {};

(function () {
    'use strict';

    Static.Views.DocumentListView = Backbone.View.extend({
        el : '#document-list-view',
        events: {
            "submit #xss-form" : "createDocument",
        },

        initialize: function () {
            var templateContent = $('#document-list-template').html();
            this.template = Handlebars.compile(templateContent)
            this.model    = new Static.Collections.Documents();

            this.listenTo(this.model, 'all', this.render);
            this.model.fetch({async: false});

            console.log(this.model.toJSON());
        },

        render: function () {
            this.$el.html(this.template({documents : this.model.toJSON()}));
            if(this.ckInstance){
                this.ckInstance.removeAllListeners();
                CKEDITOR.remove(this.ckInstance);
            }

            this.ckInstance = CKEDITOR.replace( 'document-editor', {
                allowedContent : true
            });

            return this;
        },

        close: function(){
            this.$el.html('');
            this.stopListening();
            return this;
        },

        createDocument : function(event){
            event.preventDefault();
            var content = CKEDITOR.instances['document-editor'].getData();
            var self = this;

            $.ajax({
              type: "POST",
              url: 'http://localhost:8080/documents',
              contentType: "application/json",
              data: JSON.stringify({title : 'Title', content: content}),
              success: function(){
                self.model.fetch({async: false});
              },
              dataType: 'json'
            });
        }

    });

})();
