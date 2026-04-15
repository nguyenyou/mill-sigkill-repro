package generated

final case class Data1006(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1006 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1006 = copy(value = value * k)
  def addTag(t: String): Data1006 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1006 = copy(meta = meta.updated(k, v))
  def merge(other: Data1006): Data1006 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1006 {
  given Ordering[Data1006] = Ordering.by(_.id)
  def empty: Data1006 = Data1006(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1006 =
    Data1006(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1006] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
