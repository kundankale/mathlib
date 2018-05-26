package com.mathlib;

import android.content.Context;
import android.util.Log;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * Created by Kundan Kale on 26/5/18.
 * Blancco
 * kundan.kale@blancco.com
 */
public class Add {

    Context context;
    AmazonS3 s3Client;
    public Add(Context context){

        this.context = context;
    }
    public int addNumbers(int a,int b){
        return a+b;
    }
    public void s3credentialsProvider(){

        // Initialize the AWS Credential
        Log.d("POC","Library method aws");
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider =
                new CognitoCachingCredentialsProvider(
                        context,
                        "us-east-1:521c4556-b969-456d-93ec-a3fbc8bfe37f", // Identity Pool ID
                        Regions.US_EAST_1 // Region
                );
        createAmazonS3Client(cognitoCachingCredentialsProvider);
    }
    public void createAmazonS3Client(CognitoCachingCredentialsProvider
                                             credentialsProvider){

        // Create an S3 client
        Log.d("POC","Library method aws createAmazonS3Client");
        s3Client = new AmazonS3Client(credentialsProvider);

        // Set the region of your S3 bucket
        s3Client.setRegion(Region.getRegion(Regions.US_EAST_1));
    }
}
