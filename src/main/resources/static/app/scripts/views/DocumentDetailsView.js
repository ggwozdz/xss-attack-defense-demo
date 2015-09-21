/*global Static, Backbone, JST*/

Static.Views = Static.Views || {};

(function () {
    'use strict';

    Static.Views.DocumentDetailsView = Backbone.View.extend({

        el : '#document-details-view',
        initialize: function (options) {

            var templateContent = $('#document-details-template').html();
            var self = this;
            var query = options.query;

            this.template  = Handlebars.compile(templateContent)
            this.model     = new Backbone.Model();
            this.model.url = 'http://localhost:8080/documents/details?title='+options.query;

            this.model.fetch({
                success:function(model, response, options){
                    console.log('Document with title "'+query+'" fetched ok.')
                },
                error:function(model, response, options){
                    self.error = response.responseText;
                    self.render();
                }
            })

            this.listenTo(this.model, 'all', this.render);
            this.model.fetch({async: false});

            console.log(this.model.toJSON());
        },

        render: function () {
            this.$el.html(this.template({document : this.model.toJSON(), error: this.error}));
            return this;
        },

        close: function(){
            this.$el.html('');
            this.stopListening();
            return this;
        }
    });

})();
