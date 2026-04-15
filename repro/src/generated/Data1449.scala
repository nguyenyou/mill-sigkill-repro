package generated

final case class Data1449(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1449 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1449 = copy(value = value * k)
  def addTag(t: String): Data1449 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1449 = copy(meta = meta.updated(k, v))
  def merge(other: Data1449): Data1449 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1449 {
  given Ordering[Data1449] = Ordering.by(_.id)
  def empty: Data1449 = Data1449(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1449 =
    Data1449(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1449] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
