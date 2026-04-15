package generated

final case class Data477(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data477 = copy(name = name.toUpperCase)
  def scale(k: Double): Data477 = copy(value = value * k)
  def addTag(t: String): Data477 = copy(tags = t :: tags)
  def put(k: String, v: String): Data477 = copy(meta = meta.updated(k, v))
  def merge(other: Data477): Data477 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data477 {
  given Ordering[Data477] = Ordering.by(_.id)
  def empty: Data477 = Data477(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data477 =
    Data477(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data477] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
