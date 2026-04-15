package generated

final case class Data757(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data757 = copy(name = name.toUpperCase)
  def scale(k: Double): Data757 = copy(value = value * k)
  def addTag(t: String): Data757 = copy(tags = t :: tags)
  def put(k: String, v: String): Data757 = copy(meta = meta.updated(k, v))
  def merge(other: Data757): Data757 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data757 {
  given Ordering[Data757] = Ordering.by(_.id)
  def empty: Data757 = Data757(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data757 =
    Data757(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data757] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
