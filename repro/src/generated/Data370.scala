package generated

final case class Data370(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data370 = copy(name = name.toUpperCase)
  def scale(k: Double): Data370 = copy(value = value * k)
  def addTag(t: String): Data370 = copy(tags = t :: tags)
  def put(k: String, v: String): Data370 = copy(meta = meta.updated(k, v))
  def merge(other: Data370): Data370 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data370 {
  given Ordering[Data370] = Ordering.by(_.id)
  def empty: Data370 = Data370(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data370 =
    Data370(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data370] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
