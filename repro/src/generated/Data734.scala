package generated

final case class Data734(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data734 = copy(name = name.toUpperCase)
  def scale(k: Double): Data734 = copy(value = value * k)
  def addTag(t: String): Data734 = copy(tags = t :: tags)
  def put(k: String, v: String): Data734 = copy(meta = meta.updated(k, v))
  def merge(other: Data734): Data734 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data734 {
  given Ordering[Data734] = Ordering.by(_.id)
  def empty: Data734 = Data734(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data734 =
    Data734(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data734] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
