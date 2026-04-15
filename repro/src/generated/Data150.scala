package generated

final case class Data150(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data150 = copy(name = name.toUpperCase)
  def scale(k: Double): Data150 = copy(value = value * k)
  def addTag(t: String): Data150 = copy(tags = t :: tags)
  def put(k: String, v: String): Data150 = copy(meta = meta.updated(k, v))
  def merge(other: Data150): Data150 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data150 {
  given Ordering[Data150] = Ordering.by(_.id)
  def empty: Data150 = Data150(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data150 =
    Data150(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data150] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
