package com.zxt.helper.common.utils;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */


import java.util.List;

public class TabulaPdf {
    private String extraction_method;

    private double top;

    private double left;

    private double width;

    private double height;

    private double right;

    private double bottom;

    private List<List<DataBean>> data;


    public String getExtraction_method() {
        return extraction_method;
    }


    public void setExtraction_method(String extraction_method) {
        this.extraction_method = extraction_method;
    }


    public double getTop() {
        return top;
    }


    public void setTop(double top) {
        this.top = top;
    }

    public double getLeft() {
        return left;
    }


    public void setLeft(double left) {
        this.left = left;
    }


    public double getWidth() {
        return width;
    }


    public void setWidth(double width) {
        this.width = width;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public double getRight() {
        return right;
    }


    public void setRight(double right) {
        this.right = right;
    }


    public double getBottom() {
        return bottom;
    }


    public void setBottom(double bottom) {
        this.bottom = bottom;
    }


    public List<List<DataBean>> getData() {
        return data;
    }


    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "TabulaPdf2{" +
                "extraction_method='" + extraction_method + '\'' +
                ", top=" + top +
                ", left=" + left +
                ", width=" + width +
                ", height=" + height +
                ", right=" + right +
                ", bottom=" + bottom +
                ", data=" + data +
                '}';

    }


    public static class DataBean {

        /**
         * top : 0
         * <p>
         * left : 0
         * <p>
         * width : 0
         * <p>
         * height : 0
         * <p>
         * text :
         */
        private int top;

        private int left;

        private int width;

        private int height;

        private String text;

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }


        public int getLeft() {
            return left;
        }


        public void setLeft(int left) {
            this.left = left;
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

        public String getText() {
            return text;

        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "top=" + top +
                    ", left=" + left +
                    ", width=" + width +
                    ", height=" + height +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

}