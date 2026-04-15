package generated

final case class Data937(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data937 = copy(name = name.toUpperCase)
  def scale(k: Double): Data937 = copy(value = value * k)
  def addTag(t: String): Data937 = copy(tags = t :: tags)
  def put(k: String, v: String): Data937 = copy(meta = meta.updated(k, v))
  def merge(other: Data937): Data937 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data937 {
  given Ordering[Data937] = Ordering.by(_.id)
  def empty: Data937 = Data937(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data937 =
    Data937(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data937] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
