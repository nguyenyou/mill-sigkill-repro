package generated

final case class Data118(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data118 = copy(name = name.toUpperCase)
  def scale(k: Double): Data118 = copy(value = value * k)
  def addTag(t: String): Data118 = copy(tags = t :: tags)
  def put(k: String, v: String): Data118 = copy(meta = meta.updated(k, v))
  def merge(other: Data118): Data118 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data118 {
  given Ordering[Data118] = Ordering.by(_.id)
  def empty: Data118 = Data118(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data118 =
    Data118(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data118] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
