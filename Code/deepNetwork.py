import tensorflow as tf
from tensorflow import keras
import numpy as np

def cnn_model(input_layer):

    conv0 = tf.layers.conv2d(
    inputs = input_layer,
    filters = 16,
    kernel_size = [3,3],
    padding='same',
    activation=tf.nn.relu
    )

    pool1 = tf.layers.max_pooling_2d(inputs=conv1, pool_size=[2,2], strides=2)

    conv2 = tf.layers.conv2d(
    inputs = pool1,
    filters = 32,
    kernel_size = [3,3],
    padding='same',
    activation=tf.nn.relu
    )

    conv3 = tf.layers.conv2d(
    inputs= conv2,
    filters= 64,
    kernel_size=[3,3],
    padding='same',
    activation=tf.nn.relu
    )

    pool4 = tf.layers.max_pooling_2d(inputs=conv3, pool_size=[2,2], strides=2)

    conv5 = tf.layers.conv2d(
    inputs= pool4,
    filters= 128,
    kernel_size=[3,3],
    padding='same',
    activation=tf.nn.relu
    )

    conv6 = tf.layers.conv2d(
    inputs= conv5,
    filters= 128,
    kernel_size=[3,3],
    padding='same',
    activation=tf.nn.relu
    )

    conv7 = tf.layers.conv2d(
    inputs= conv6,
    filters= 128,
    kernel_size=[3,3],
    padding='same',
    activation=tf.nn.relu
    )

    conv8 = tf.layers.conv2d(
    inputs= conv7,
    filters= 256,
    kernel_size=[3,3],
    padding='same',
    activation=tf.nn.relu
    )

    conv9 = tf.layers.conv2d(
    inputs= conv8,
    filters= 512,
    kernel_size=[3,3],
    padding='same',
    activation=tf.nn.relu
    )

    conv10 = tf.layers.conv2d(
    inputs= conv9,
    filters= 26,
    kernel_size=[1,1],
    padding='same',
    activation=tf.nn.relu
    )

    avg11 = tf.keras.layers.average(inputs=conv10)

    probabilities = tf.nn.softmax(avg11,name='softmax_tensor')
