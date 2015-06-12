package model;

import java.util.Comparator;

/**
 * Created by nazar on 11.06.15.
 */
public class Item implements Comparator<Item>, Comparable<Item>{
        int id;
        int parent_id;
        String title;
        String img;
        String content;

        public int getParent_id() {
                return parent_id;
        }

        public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getImg() {
                return img;
        }

        public void setImg(String url) {
                this.img = url;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        @Override
        public int compareTo(Item item) {
                return this.getTitle().compareTo(item.getTitle());
        }

        @Override
        public int compare(Item item, Item t1) {
                return item.getTitle().compareTo(t1.getTitle());
        }
}
