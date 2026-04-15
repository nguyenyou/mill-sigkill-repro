package generated

final case class Data85(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data85 = copy(name = name.toUpperCase)
  def scale(k: Double): Data85 = copy(value = value * k)
  def addTag(t: String): Data85 = copy(tags = t :: tags)
  def put(k: String, v: String): Data85 = copy(meta = meta.updated(k, v))
  def merge(other: Data85): Data85 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data85 {
  given Ordering[Data85] = Ordering.by(_.id)
  def empty: Data85 = Data85(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data85 =
    Data85(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data85] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
