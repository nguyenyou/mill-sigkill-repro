package generated

final case class Data481(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data481 = copy(name = name.toUpperCase)
  def scale(k: Double): Data481 = copy(value = value * k)
  def addTag(t: String): Data481 = copy(tags = t :: tags)
  def put(k: String, v: String): Data481 = copy(meta = meta.updated(k, v))
  def merge(other: Data481): Data481 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data481 {
  given Ordering[Data481] = Ordering.by(_.id)
  def empty: Data481 = Data481(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data481 =
    Data481(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data481] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
