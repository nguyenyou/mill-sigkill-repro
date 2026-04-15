package generated

final case class Data191(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data191 = copy(name = name.toUpperCase)
  def scale(k: Double): Data191 = copy(value = value * k)
  def addTag(t: String): Data191 = copy(tags = t :: tags)
  def put(k: String, v: String): Data191 = copy(meta = meta.updated(k, v))
  def merge(other: Data191): Data191 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data191 {
  given Ordering[Data191] = Ordering.by(_.id)
  def empty: Data191 = Data191(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data191 =
    Data191(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data191] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
