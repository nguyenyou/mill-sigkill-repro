package generated

final case class Data684(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data684 = copy(name = name.toUpperCase)
  def scale(k: Double): Data684 = copy(value = value * k)
  def addTag(t: String): Data684 = copy(tags = t :: tags)
  def put(k: String, v: String): Data684 = copy(meta = meta.updated(k, v))
  def merge(other: Data684): Data684 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data684 {
  given Ordering[Data684] = Ordering.by(_.id)
  def empty: Data684 = Data684(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data684 =
    Data684(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data684] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
