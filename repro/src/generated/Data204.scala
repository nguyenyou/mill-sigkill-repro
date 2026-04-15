package generated

final case class Data204(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data204 = copy(name = name.toUpperCase)
  def scale(k: Double): Data204 = copy(value = value * k)
  def addTag(t: String): Data204 = copy(tags = t :: tags)
  def put(k: String, v: String): Data204 = copy(meta = meta.updated(k, v))
  def merge(other: Data204): Data204 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data204 {
  given Ordering[Data204] = Ordering.by(_.id)
  def empty: Data204 = Data204(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data204 =
    Data204(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data204] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
