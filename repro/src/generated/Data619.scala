package generated

final case class Data619(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data619 = copy(name = name.toUpperCase)
  def scale(k: Double): Data619 = copy(value = value * k)
  def addTag(t: String): Data619 = copy(tags = t :: tags)
  def put(k: String, v: String): Data619 = copy(meta = meta.updated(k, v))
  def merge(other: Data619): Data619 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data619 {
  given Ordering[Data619] = Ordering.by(_.id)
  def empty: Data619 = Data619(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data619 =
    Data619(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data619] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
