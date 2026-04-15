package generated

final case class Data1267(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1267 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1267 = copy(value = value * k)
  def addTag(t: String): Data1267 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1267 = copy(meta = meta.updated(k, v))
  def merge(other: Data1267): Data1267 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1267 {
  given Ordering[Data1267] = Ordering.by(_.id)
  def empty: Data1267 = Data1267(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1267 =
    Data1267(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1267] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
