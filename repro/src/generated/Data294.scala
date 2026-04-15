package generated

final case class Data294(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data294 = copy(name = name.toUpperCase)
  def scale(k: Double): Data294 = copy(value = value * k)
  def addTag(t: String): Data294 = copy(tags = t :: tags)
  def put(k: String, v: String): Data294 = copy(meta = meta.updated(k, v))
  def merge(other: Data294): Data294 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data294 {
  given Ordering[Data294] = Ordering.by(_.id)
  def empty: Data294 = Data294(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data294 =
    Data294(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data294] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
