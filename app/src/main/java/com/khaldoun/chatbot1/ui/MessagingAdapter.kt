package com.khaldoun.chatbot1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaldoun.chatbot1.R
import com.khaldoun.chatbot1.R.layout.message_item
import com.khaldoun.chatbot1.data.Message
import com.khaldoun.chatbot1.utilis.Constants.RECEIVE_ID
import com.khaldoun.chatbot1.utilis.Constants.SEND_ID
import kotlinx.android.synthetic.main.message_item.view.*
//this messaging adapter class inherits from recyclerview.adapter
class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messagesList = mutableListOf<Message>()
    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{
                messagesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(message_item, parent, false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messagesList[position]

        when(currentMessage.id){
            SEND_ID -> {
                holder.itemView.tv_message.apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility = View.GONE
            }
            RECEIVE_ID -> {
                holder.itemView.tv_bot_message.apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_message.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    fun insertMessage(message: Message){
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }
}









