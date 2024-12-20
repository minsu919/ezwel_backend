package mvc;

public class BoardDTO {
	String title, contents, writer, writingTime;
	int seq, writepw, viewCount;
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(String title, String contents, String writer, String writingTime, int seq, int writepw,
			int viewCount) {
		super();
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writingTime = writingTime;
		this.seq = seq;
		this.writepw = writepw;
		this.viewCount = viewCount;
	}

	public BoardDTO(String title, String contents, int writepw, String writer) {
		// TODO for insertBoard
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writepw = writepw;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWritingTime() {
		return writingTime;
	}

	public void setWritingTime(String writingTime) {
		this.writingTime = writingTime;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getWritepw() {
		return writepw;
	}

	public void setWritepw(int writepw) {
		this.writepw = writepw;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "BoardDTO [title=" + title + ", contents=" + contents + ", writer=" + writer + ", writingTime="
				+ writingTime + ", seq=" + seq + ", writepw=" + writepw + ", viewCount=" + viewCount + "]";
	}
	
	
	
}
