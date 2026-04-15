package generated

final case class Data894(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data894 = copy(name = name.toUpperCase)
  def scale(k: Double): Data894 = copy(value = value * k)
  def addTag(t: String): Data894 = copy(tags = t :: tags)
  def put(k: String, v: String): Data894 = copy(meta = meta.updated(k, v))
  def merge(other: Data894): Data894 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data894 {
  given Ordering[Data894] = Ordering.by(_.id)
  def empty: Data894 = Data894(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data894 =
    Data894(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data894] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
