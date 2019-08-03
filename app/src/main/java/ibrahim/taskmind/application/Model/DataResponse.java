package ibrahim.taskmind.application.Model;

import androidx.annotation.Nullable;

import java.util.List;

public class DataResponse
{

    @Nullable
    private String id;
    @Nullable
    private String created_at;
    @Nullable
    private int width;
    @Nullable
    private int height;
    @Nullable
    private String color;
    @Nullable
    private int likes;
    @Nullable
    private boolean liked_by_user;
    @Nullable
    private UserBean user;
    @Nullable
    private UrlsBean urls;
    @Nullable
    private LinksBeanX links;
    @Nullable
    private List<CategoriesBean> categories;

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable String id) {
        this.id = id;
    }

    @Nullable
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(@Nullable String created_at) {
        this.created_at = created_at;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Nullable
    public String getColor() {
        return color;
    }

    public void setColor(@Nullable String color) {
        this.color = color;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    @Nullable
    public UserBean getUser() {
        return user;
    }

    public void setUser(@Nullable UserBean user) {
        this.user = user;
    }

    @Nullable
    public UrlsBean getUrls() {
        return urls;
    }

    public void setUrls(@Nullable UrlsBean urls) {
        this.urls = urls;
    }

    @Nullable
    public LinksBeanX getLinks() {
        return links;
    }

    public void setLinks(@Nullable LinksBeanX links) {
        this.links = links;
    }

    @Nullable
    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(@Nullable List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class UserBean {

        @Nullable
        private String id;
        @Nullable
        private String username;
        @Nullable
        private String name;
        @Nullable
        private ProfileImageBean profile_image;
        @Nullable
        private LinksBean links;

        @Nullable
        public String getId() {
            return id;
        }

        public void setId(@Nullable String id) {
            this.id = id;
        }

        @Nullable
        public String getUsername() {
            return username;
        }

        public void setUsername(@Nullable String username) {
            this.username = username;
        }

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }

        @Nullable
        public ProfileImageBean getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(@Nullable ProfileImageBean profile_image) {
            this.profile_image = profile_image;
        }

        @Nullable
        public LinksBean getLinks() {
            return links;
        }

        public void setLinks(@Nullable LinksBean links) {
            this.links = links;
        }

        public static class ProfileImageBean {

            @Nullable
            private String small;
            @Nullable
            private String medium;
            @Nullable
            private String large;

            @Nullable
            public String getSmall() {
                return small;
            }

            public void setSmall(@Nullable String small) {
                this.small = small;
            }

            @Nullable
            public String getMedium() {
                return medium;
            }

            public void setMedium(@Nullable String medium) {
                this.medium = medium;
            }

            @Nullable
            public String getLarge() {
                return large;
            }

            public void setLarge(@Nullable String large) {
                this.large = large;
            }
        }

        public static class LinksBean {
            /**
             * self : https://api.unsplash.com/users/nicholaskampouris
             * html : http://unsplash.com/@nicholaskampouris
             * photos : https://api.unsplash.com/users/nicholaskampouris/photos
             * likes : https://api.unsplash.com/users/nicholaskampouris/likes
             */

            @Nullable
            private String self;
            @Nullable
            private String html;
            @Nullable
            private String photos;
            @Nullable
            private String likes;


            @Nullable
            public String getSelf() {
                return self;
            }

            public void setSelf(@Nullable String self) {
                this.self = self;
            }

            @Nullable
            public String getHtml() {
                return html;
            }

            public void setHtml(@Nullable String html) {
                this.html = html;
            }

            @Nullable
            public String getPhotos() {
                return photos;
            }

            public void setPhotos(@Nullable String photos) {
                this.photos = photos;
            }

            @Nullable
            public String getLikes() {
                return likes;
            }

            public void setLikes(@Nullable String likes) {
                this.likes = likes;
            }
        }
    }

    public static class UrlsBean {
        /**
         * raw : https://images.unsplash.com/photo-1464550883968-cec281c19761
         * full : https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=4b142941bfd18159e2e4d166abcd0705
         * regular : https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=1080&fit=max&s=1881cd689e10e5dca28839e68678f432
         * small : https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=400&fit=max&s=d5682032c546a3520465f2965cde1cec
         * thumb : https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=200&fit=max&s=9fba74be19d78b1aa2495c0200b9fbce
         */

        @Nullable
        private String raw;
        @Nullable
        private String full;
        @Nullable
        private String regular;
        @Nullable
        private String small;
        @Nullable
        private String thumb;

        @Nullable
        public String getRaw() {
            return raw;
        }

        public void setRaw(@Nullable String raw) {
            this.raw = raw;
        }

        @Nullable
        public String getFull() {
            return full;
        }

        public void setFull(@Nullable String full) {
            this.full = full;
        }

        @Nullable
        public String getRegular() {
            return regular;
        }

        public void setRegular(@Nullable String regular) {
            this.regular = regular;
        }

        @Nullable
        public String getSmall() {
            return small;
        }

        public void setSmall(@Nullable String small) {
            this.small = small;
        }

        @Nullable
        public String getThumb() {
            return thumb;
        }

        public void setThumb(@Nullable String thumb) {
            this.thumb = thumb;
        }
    }

    public static class LinksBeanX {
        /**
         * self : https://api.unsplash.com/photos/4kQA1aQK8-Y
         * html : http://unsplash.com/photos/4kQA1aQK8-Y
         * download : http://unsplash.com/photos/4kQA1aQK8-Y/download
         */

        @Nullable
        private String self;
        @Nullable
        private String html;
        @Nullable
        private String download;

        @Nullable
        public String getSelf() {
            return self;
        }

        public void setSelf(@Nullable String self) {
            this.self = self;
        }

        @Nullable
        public String getHtml() {
            return html;
        }

        public void setHtml(@Nullable String html) {
            this.html = html;
        }

        @Nullable
        public String getDownload() {
            return download;
        }

        public void setDownload(@Nullable String download) {
            this.download = download;
        }
    }

    public static class CategoriesBean {
        /**
         * id : 4
         * title : Nature
         * photo_count : 46148
         * links : {"self":"https://api.unsplash.com/categories/4","photos":"https://api.unsplash.com/categories/4/photos"}
         */

        @Nullable
        private int id;
        @Nullable
        private String title;
        @Nullable
        private int photo_count;
        @Nullable
        private LinksBeanXX links;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Nullable
        public String getTitle() {
            return title;
        }

        public void setTitle(@Nullable String title) {
            this.title = title;
        }

        public int getPhoto_count() {
            return photo_count;
        }

        public void setPhoto_count(int photo_count) {
            this.photo_count = photo_count;
        }

        @Nullable
        public LinksBeanXX getLinks() {
            return links;
        }

        public void setLinks(@Nullable LinksBeanXX links) {
            this.links = links;
        }

        public static class LinksBeanXX {
            /**
             * self : https://api.unsplash.com/categories/4
             * photos : https://api.unsplash.com/categories/4/photos
             */

            @Nullable
            private String self;
            @Nullable
            private String photos;

            @Nullable
            public String getSelf() {
                return self;
            }

            public void setSelf(@Nullable String self) {
                this.self = self;
            }

            @Nullable
            public String getPhotos() {
                return photos;
            }

            public void setPhotos(@Nullable String photos) {
                this.photos = photos;
            }
        }
    }
}
