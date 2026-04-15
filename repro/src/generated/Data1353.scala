package generated

final case class Data1353(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1353 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1353 = copy(value = value * k)
  def addTag(t: String): Data1353 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1353 = copy(meta = meta.updated(k, v))
  def merge(other: Data1353): Data1353 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1353 {
  given Ordering[Data1353] = Ordering.by(_.id)
  def empty: Data1353 = Data1353(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1353 =
    Data1353(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1353] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
