package generated

final case class Data1201(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1201 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1201 = copy(value = value * k)
  def addTag(t: String): Data1201 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1201 = copy(meta = meta.updated(k, v))
  def merge(other: Data1201): Data1201 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1201 {
  given Ordering[Data1201] = Ordering.by(_.id)
  def empty: Data1201 = Data1201(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1201 =
    Data1201(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1201] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
