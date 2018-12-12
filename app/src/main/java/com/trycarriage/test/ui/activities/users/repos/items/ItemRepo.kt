package com.trycarriage.test.ui.activities.users.repos.items

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.items.AbstractItem
import com.trycarriage.test.R
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import kotlinx.android.synthetic.main.item_item_repo.view.*

class ItemRepo : AbstractItem<ItemRepo, ItemRepo.RepoViewHolder>() {

    lateinit var repo: Repo

    fun withRepo(repo: Repo): ItemRepo {
        this.repo = repo
        return this
    }

    override fun getType(): Int {
        return R.id.item_item_repo
    }

    override fun getViewHolder(v: View?): RepoViewHolder {
        return RepoViewHolder(v!!)
    }

    override fun getLayoutRes(): Int {
        return R.layout.item_item_repo
    }


    override fun bindView(holder: RepoViewHolder?, payloads: MutableList<Any>?) {
        super.bindView(holder, payloads)
        holder?.let {
            it.itemView.textTitle.text = repo.fullName
            it.itemView.textSubTitle.text = repo.description
            it.itemView.textTag.text = String.format("%s Forks", repo.forksCount.toString())
            it.itemView.textTag2.text = String.format("%s Watcher", repo.watchers.toString())
            it.itemView.textOne.text = String.format("Default Branch/%s", repo.defaultBranch)
        }
    }

    class RepoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
}