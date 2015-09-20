/*global Static, Backbone, CKEDITOR*/

Static.Views = Static.Views || {};

(function () {
    'use strict';

    Static.Views.XSSEditorView = Backbone.View.extend({
        el : '#xss-editor-view',
        events: {
            "submit #xss-form" : "addComment",
        },

        initialize: function () {
            var templateContent = $('#xss-editor-template').html();
            this.template = Handlebars.compile(templateContent)
            this.model    = new Static.Collections.TextEntries();

            this.listenTo(this.model, 'all', this.render);
            this.model.fetch({async: false});

            console.log(this.model.toJSON());
        },

        render: function () {
            this.$el.html(this.template({entries : this.model.toJSON()}));
            if(this.ckInstance){
                this.ckInstance.removeAllListeners();
                CKEDITOR.remove(this.ckInstance);
            }

            this.ckInstance = CKEDITOR.replace( 'editor1', {
                allowedContent : true
            });

            return this;
        },

        close: function(){
            this.$el.html('');
            this.stopListening();
            return this;
        },

        addComment : function(event){
            event.preventDefault();
            var content = CKEDITOR.instances.editor1.getData();
            var self = this;







            $.ajax({
              type: "POST",
              url: 'http://localhost:8080/textEntries',
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
